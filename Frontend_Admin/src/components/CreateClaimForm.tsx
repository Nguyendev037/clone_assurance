import React, { useEffect, useState } from "react";
import { Base_Axios } from "../axios";

export type ClaimType = {
  description: string;
  hospital: string;
  admissionDate: string;
  dischargeDate: string;
  diagnosis: string;
  payoutAmount: number;
  client_id: number;
  signed_offer_id: string;
};

type SignOffer = {
    id : string
}

function CreateClaimForm({data} : {data : SignOffer}) {
  const [form, setForm] = useState<ClaimType>({
    description: "",
    hospital: "",
    admissionDate: "",
    dischargeDate: "",
    diagnosis: "",
    payoutAmount: 0,
    client_id: 0,
    signed_offer_id: data.id,
  });

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("user") || "{}");
    setForm((prev) => ({ ...prev, client_id: user?.id || 0 }));
  }, []);

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    const { name, value } = event.target;
    setForm((prevForm) => ({
      ...prevForm,
      [name]: name === "payoutAmount" ? parseFloat(value) : value,
    }));
  }

  async function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    try {
      const response = await Base_Axios.post("/claim", form);
      if (response.status === 201) {
        console.log(response.data);
      }
    } catch (error) {
      console.error("Error submitting claim:", error);
    }
  }

  return (
    <form id="claim-form" className="modal-content animate" onSubmit={handleSubmit}>
      <div className="container">
        <h1 className="mb-10 text-lg text-center">File Claim</h1>

        <label htmlFor="hospital">
          <b>Hospital</b>
        </label>
        <input
          type="text"
          placeholder="Enter hospital"
          name="hospital"
          value={form.hospital}
          onChange={handleChange}
          required
        />

        <label htmlFor="diagnosis">
          <b>Diagnosis</b>
        </label>
        <input
          type="text"
          placeholder="Enter diagnosis"
          name="diagnosis"
          value={form.diagnosis}
          onChange={handleChange}
          required
        />

        <label htmlFor="description">
          <b>Description</b>
        </label>
        <input
          type="text"
          placeholder="Enter description"
          name="description"
          value={form.description}
          onChange={handleChange}
          required
        />

        <label htmlFor="admissionDate">
          <b>Admission Date</b>
        </label>
        <input
          type="date"
          id="admissionDate"
          name="admissionDate"
          value={form.admissionDate}
          onChange={handleChange}
          required
        />

        <label htmlFor="dischargeDate">
          <b>Discharge Date</b>
        </label>
        <input
          type="date"
          id="dischargeDate"
          name="dischargeDate"
          value={form.dischargeDate}
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

export default CreateClaimForm;
