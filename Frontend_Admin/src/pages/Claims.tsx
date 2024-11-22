import Table from "../components/Table";
import Modal from "../components/Modal";
import ClaimForm from "../components/ClaimForm";
import { useEffect, useState } from "react";
import { Base_Axios } from "../axios";
import DenyClaimForm from "../components/DenyClaimForm";

export type ClaimDataType = {
  id: number,
  client_id: number,
  signed_offer_id: string,
  description: number,
  claimDate: Date,
  hospital: string,
  admissionDate: Date,
  dischargeDate: Date,
  diagnosis: string,
  payoutAmount: number,
  status: "PENDING" | "ACCEPTED" | "DENIED",
  reason: string,
  payoutId: string
}

function Claims() {
  const [data, Setdata] = useState([]);
  const [form, setForm] = useState<React.JSX.Element | null>(null);
  const [open, setOpen] = useState<boolean>(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await Base_Axios.get(`/claim`);
        console.log("API Response:", response.data);
        Setdata(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, []);

  function acceptClaim(id: number) {
    setForm(<ClaimForm data={data[id]} setOpen={setOpen}/>);
    setOpen(true);
  }

  async function denyClaim(id: number) {
    setForm(<DenyClaimForm data={data[id]}/>)
    setOpen(true);
  }
  

  return (
    <div>
      <Table
        model="claims"
        data={data}
        buttons={[{ action: acceptClaim, actionName: "Accept" }, 
          { action: denyClaim, actionName: 'Deny'}]}
      />
      <Modal buttonText="accept claim" open={open} setOpen={setOpen} content={form} />
    </div>
  );
}

export default Claims;
