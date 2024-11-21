import React, {useEffect, useState} from 'react'
import {Base_Axios} from "../axios.ts";
interface PropPass {
    model: String;
}

export default function LandingPage({model}: PropPass) {

    const [data,Setdata] = useState({});
    const fetchAllData = async () => {
        try {
            const response = await Base_Axios.get(`/${model}`);
            return response.data;
        } catch (error) {
            console.error(error);
        }
    }

    useEffect(()=> {
        Setdata(fetchAllData());
    },[])

    return (
        <section className="table-auto">
        </section>
    )
}
