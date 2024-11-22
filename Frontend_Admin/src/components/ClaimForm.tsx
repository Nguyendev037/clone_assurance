import { useEffect, useState } from "react";
import { Base_Axios } from "../axios";
import { ClaimDataType } from "../pages/AdminClaims";

type FormState = {
  amount: number;
  signed_offer_id: string;
  case_payout_id: number;
  receiver_id: number;
  claim_id: number;
};

type Case = {
  description: string;
  id: number;
  name: string;
};

type CaseInOffer = {
  id: number;
  name: number;
  description: string;
  caseType: Case;
};

type Offer = {
  id: string;
  clientId: number;
  offer: {
    cases: CaseInOffer[];
    description: string | null;
    id: number;
    name: string;
    payoutAmount: number;
    years: number;
  };
  isActive: boolean;
  startDate: Date;
  endDate: Date;
  paymentAmount: number;
};

function ClaimForm({
  setOpen,
  data,
}: {
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
  data: ClaimDataType;
}) {
  const [form, setForm] = useState<FormState>({
    amount: 0,
    signed_offer_id: data.signed_offer_id,
    case_payout_id: 0,
    receiver_id: data.client_id,
    claim_id: data.id,
  });

  const [offer, setOffer] = useState<Offer>();
  useEffect(() => {
    const fetchOffer = async () => {
      try {
        const response = await Base_Axios.get(`/sign/${data.signed_offer_id}`);
        if (response.status === 200) {
          const temp: Offer = response.data;
          setOffer(temp);
          setForm((prevForm) => ({
            ...prevForm,
            case_payout_id: temp?.offer.cases[0]?.id ?? 0,
          }));
        }
      } catch (error) {
        console.error(error);
      }
    };
    fetchOffer();
  }, [data.signed_offer_id]);

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    const { name, value } = event.target;
    setForm((prevForm) => ({
      ...prevForm,
      [name]: name === "amount" ? parseFloat(value) : value,
    }));
  }

  async function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    try {
      const response = await Base_Axios.post("/payout", form);
      if (response.status === 201) {
        console.log(response.data);
      }
    } catch (error) {
      console.log(error);
    }
    setOpen(false);
  }

  return (
    <form
      id="claim-form"
      className="modal-content animate"
      onSubmit={handleSubmit}
    >
      <div className="container">
        <h1 className="mb-10 text-lg text-center">Accept Claim Form</h1>
        <label htmlFor="amount">
          <b>Amount</b>
        </label>
        <input
          type="number"
          placeholder="Enter Amount"
          name="amount"
          value={form.amount}
          onChange={handleChange}
          required
        />

        <label htmlFor="signed_offer_id">
          <b>Signed Offer ID</b>
        </label>
        <input
          type="text"
          name="signed_offer_id"
          value={form.signed_offer_id}
          readOnly
        />

        <label htmlFor="case_payout_id">
          <b>Case</b>
        </label>
        <select
          name="case_payout_id"
          value={form.case_payout_id}
          onChange={(e) => {
            setForm((prevForm) => ({
              ...prevForm,
              case_payout_id: parseInt(e.target.value),
            }));
          }}
          style={{
            width: "100%",
          }}
        >
          {offer?.offer?.cases.map((item, index) => {
            return (
              <option
                value={item.id}
                key={index}
                selected={item.id == form.case_payout_id}
              >
                {item.caseType.name}
              </option>
            );
          })}
        </select>

        <div className="flex justify-center mt-4">
          <button
            type="submit"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-24"
          >
            Submit Claim
          </button>
        </div>
      </div>
    </form>
  );
}

export default ClaimForm;
