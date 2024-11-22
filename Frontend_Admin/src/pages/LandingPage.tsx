import { useEffect, useState } from "react";
import Table from "../components/Table.tsx";
import { Base_Axios } from "../axios.ts";
import Snackbar from "../components/Snackbar.tsx";

type OfferType = {
    id : number
}

export default function LandingPage() {
    const [data, setData] = useState([]); // Use camelCase for setter function
    
    const [open, setOpen] = useState(false);
    const [openError, setOpenError] = useState<boolean>(false);
    const model = "products";

    // Edit Function
    const editFunction = (id: number) => {
        console.log("id component", id);
    };

    // Signed Function
    const signedFunction = async (offerId: number) => {
        try {
            const offer : OfferType = data[offerId];
            const user = JSON.parse(localStorage.getItem("user") || "{}");
            const userId  = user?.id ;
            console.log(userId);
            const startDate = new Date().toISOString(); 
            
            const clientResponse = await  Base_Axios.get(`/client/${userId}`);
            const clientId = clientResponse.data;
            
            const signedParam = {
                clientId,
                offerId : offer.id,
                startDate,
            };
            // Make the POST request
            const response = await Base_Axios.post("/sign", signedParam);
            console.log("Signed Offer Response:", response.data);
            setOpen(true);
            return response.data; // Return response if needed
        } catch (error) {
            setOpenError(true);
            console.error("Error posting data:", error);
        }
    };

    // Fetch Data
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await Base_Axios.get(`/${model}`);
                console.log("API Response:", response.data);
                setData(response.data);
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };
        fetchData();
    }, [model]);
    
    return (
        <>
            <Table
                model={model}
                data={data}
                buttons={[
                    {
                        actionName: "edit",
                        action: editFunction,
                    },
                    {
                        actionName: "signedOffer",
                        action: signedFunction,
                    },
                ]}
            />
            <Snackbar text="Congratulations! for your payment" open={open} setOpen={setOpen} />
            <Snackbar text="Payment is Errored" open={openError} setOpen={setOpenError} />
        </>
    );
}
