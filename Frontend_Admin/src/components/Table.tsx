import React, {useEffect, useState} from 'react'
import {Base_Axios} from "../axios.ts";
interface PropPass {
    model: String;
}

export default function Table({model}: PropPass) {

    const [data, Setdata] = useState<any[]>([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await Base_Axios.get(`/${model}`);
                console.log("API Response:", response.data); // Check what is being returned
                Setdata(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        fetchData();
    }, [model]);


    let headers = data.length > 0 ? Object.keys(data[0]) : [];
    headers = [...headers, "actions"];

    return (
        <section className="sm:px-6 w-full">
            <div className="px-4 md:px-10 py-4 md:py-7">
                <div className="flex row items-center justify-between">
                    <p
                        className="focus:outline-none text-base sm:text-lg md:text-xl lg:text-2xl font-bold leading-normal text-gray-800 uppercase">{model}</p>
                    <div
                        className="py-3 px-4 flex items-center text-sm font-medium leading-none text-gray-600 bg-gray-200 hover:bg-gray-300 cursor-pointer rounded">
                        <p>Sort By:</p>
                        <select aria-label="select"
                                className="focus:text-indigo-600 focus:outline-none bg-transparent ml-1">
                            <option className="text-sm text-indigo-800">Latest</option>
                            <option className="text-sm text-indigo-800">Oldest</option>
                            <option className="text-sm text-indigo-800">Latest</option>
                        </select>
                    </div>
                </div>
            </div>
            <div className="bg-white py-4 md:py-7 px-4 md:px-8 xl:px-10">
                <div className="sm:flex items-center justify-between">
                    <div className="flex items-center">
                        <a className="rounded-full focus:outline-none focus:ring-2  focus:bg-indigo-50 focus:ring-indigo-800"
                        >
                            <div className="py-2 px-8 bg-indigo-100 text-indigo-700 rounded-full">
                                <p>All</p>
                            </div>
                        </a>
                        <a className="rounded-full focus:outline-none focus:ring-2 focus:bg-indigo-50 focus:ring-indigo-800 ml-4 sm:ml-8"
                        >
                            <div
                                className="py-2 px-8 text-gray-600 hover:text-indigo-700 hover:bg-indigo-100 rounded-full ">
                                <p>Done</p>
                            </div>
                        </a>
                        <a className="rounded-full focus:outline-none focus:ring-2 focus:bg-indigo-50 focus:ring-indigo-800 ml-4 sm:ml-8"
                        >
                            <div
                                className="py-2 px-8 text-gray-600 hover:text-indigo-700 hover:bg-indigo-100 rounded-full ">
                                <p>Pending</p>
                            </div>
                        </a>
                    </div>
                    <button
                        className="focus:ring-2 focus:ring-offset-2 focus:ring-indigo-600 mt-4 sm:mt-0 inline-flex items-start justify-start px-6 py-3 bg-indigo-700 hover:bg-indigo-600 focus:outline-none rounded">
                        <p className="text-sm font-medium leading-none text-white">Add {model}</p>
                    </button>
                </div>
            </div>
            <div className="relative overflow-x-auto">
                <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                    <thead className="text-xs text-lef text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        {headers.map((header) => (
                            <th key={header} scope="col" className="px-6 py-3 text-blue-600">
                                {header}
                            </th>
                        ))}
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data.map((item, index) => (
                            <tr key={index}>
                                {headers.map((key) => (
                                    <td key={key}>
                                        {item[key]}
                                    </td>
                                ))}

                                <td>
                                    <button>Edit</button>
                                    <button>Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        </section>
    )
}
