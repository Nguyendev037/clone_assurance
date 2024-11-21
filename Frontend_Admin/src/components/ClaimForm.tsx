import { useEffect, useState } from "react";
import { Base_Axios } from "../axios";
import { AxiosError } from "axios";

type FormState = {
    amount: number;
    signed_offer_id: string;
    case_payout_id: number;
    receiver_id: number;
    claim_id: number;
  };
  
  type UserState = {
    id: number;
    name: string;
    bankAccount: string;
    address: string;
    phone: string;
    email: string;
  };

function ClaimForm() {
  const [form, setForm] = useState<FormState>({
    amount: 0,
    signed_offer_id: "",
    case_payout_id: 0,
    receiver_id: 0,
    claim_id: 0,
  });

  useEffect(() => {
    const user = sessionStorage.getItem("user");
    if (user) {
      const parsedUser: UserState = JSON.parse(user);
      setForm((prevForm) => ({
        ...prevForm,
        receiver_id: parsedUser.id,
      }));
    }
  }, []);

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
      if (error instanceof AxiosError) {
        console.log(`Error signing in: ${error.message || "Unknown error"}`);
      } else {
        console.log("An unexpected error occurred");
      }
    }
  }

  return (
    <form
      id="claim-form"
      className="modal-content animate"
      onSubmit={handleSubmit}
    >
      <div className="container">
        <div></div>
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
          type="number"
          name="amount"
          value={form.signed_offer_id}
          onChange={handleChange}
          readOnly
        />

        <label htmlFor="case_payout_id">
          <b>Case Payout ID</b>
        </label>
        <input
          type="number"
          name="amount"
          value={form.case_payout_id}
          onChange={handleChange}
          readOnly
        />

        <label htmlFor="claim_id">
          <b>Claim ID</b>
        </label>
        <input
          type="number"
          name="amount"
          value={form.claim_id}
          onChange={handleChange}
          readOnly
        />

        <button
          type="submit"
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Submit Claim
        </button>
      </div>
    </form>
  );
}

export default ClaimForm;
