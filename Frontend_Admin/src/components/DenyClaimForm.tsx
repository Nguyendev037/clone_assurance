import React, { useState } from "react";
import { Base_Axios } from "../axios";
import { ClaimDataType } from "../pages/AdminClaims";
import Snackbar from "./Snackbar";

function DenyClaimForm({
  data
}: {
  data : ClaimDataType
}) {
  const [reason, setReason] = useState<string>();
  const [message,setMessage] = useState<string>("")
  const [snackbarOpen, setSnackBarOpen] = useState<boolean>(false);

  async function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    try {
      const response = await Base_Axios.post(`/claim/decline?claim_id=${data.id}&reason=${reason}`);
      setMessage(response.data)
    } catch (error) {
      console.log(error);
    }
}

  return (
    <form
      id="claim-form"
      className="modal-content animate"
      onSubmit={handleSubmit}
    >
      <h1 className="mb-10 text-lg text-center">Deny Claim Form</h1>
      <div className="container">
        <label htmlFor="amount">
          <b>Reason</b>
        </label>
        <input
          type="text"
          placeholder="Enter reason"
          name="amount"
          value={reason}
          onChange={(e) => setReason(e.target.value)}
          required
        />

        <div className="flex justify-center mt-4">
          <button
            type="submit"
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          >
            Deny Claim
          </button>
        </div>
      </div>
      <Snackbar text={message} open={snackbarOpen} setOpen={setSnackBarOpen}/>
    </form>
  );
}

export default DenyClaimForm;
