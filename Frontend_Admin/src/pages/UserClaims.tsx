import { useEffect, useState } from "react";
import Table from "../components/Table.tsx";
import { Base_Axios } from "../axios.ts";
import Modal from "../components/Modal";
import CreateClaimForm, { SignOffer } from "../components/CreateClaimForm";
import Snackbar from "../components/Snackbar.tsx";

function UserClaims() {
  const [data, setData] = useState<SignOffer[]>([]);
  const [offer,setOffer] = useState<SignOffer>();

  const [success, setSuccess] = useState<boolean>(false);
  
  const model = "sign";
  // Fetch Data
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await Base_Axios.get(`/${model}`);
        console.log("API Response:", response.data);
        
        const transformedData = response.data.map((item) =>(
            { ...item, offer: item.offer.name}
        ))
        
        setData(transformedData);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, [model]);


  const [open, setOpen] = useState<boolean>(false);

  function createClaim(id: number) {
    setOffer(data[id])
    setOpen(true);
  }

  return (
    <div>
      <>
        <Table model={model} data={data} buttons={[{
            actionName : 'File claim', action : createClaim 
        }]} />
        <Modal
          buttonText="accept claim"
          open={open}
          setOpen={setOpen}
          content={<CreateClaimForm data={offer} setSuccess={setSuccess} />}
        />
        <Snackbar text="You Claim Request is success" open={success} setOpen={setSuccess} />
      </>
    
    </div>
  );
}

export default UserClaims;
