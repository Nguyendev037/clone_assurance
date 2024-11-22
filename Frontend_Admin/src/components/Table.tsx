type Button = {
    action: (id: number) => void;
    actionName: string;
};

interface PropPass {
    buttons: Button[];
    data: Array<Record<string, unknown>>;
    model: string;
}

export default function Table({buttons, data, model}: PropPass) {
    const headers = data.length > 0 ? Object.keys(data[0]) : [];
    
    return (
        <section className="sm:px-6 w-full">
            <div className="px-4 md:px-10 py-2 md:pt-7 ">
                <div className="flex row items-center justify-between">
                    <p className="focus:outline-none text-base sm:text-lg md:text-xl lg:text-2xl font-bold leading-normal text-gray-800 uppercase">
                        {model}
                    </p>
                    <div
                        className="py-3 px-4 flex items-center text-sm font-medium leading-none text-gray-600 bg-gray-200 hover:bg-gray-300 cursor-pointer rounded">
                        <p>Sort By:</p>
                        <select
                            aria-label="select"
                            className="focus:text-indigo-600 focus:outline-none bg-transparent ml-1"
                        >
                            <option className="text-sm text-indigo-800">Latest</option>
                            <option className="text-sm text-indigo-800">Oldest</option>
                            <option className="text-sm text-indigo-800">Latest</option>
                        </select>
                    </div>
                </div>
            </div>
            <div className="mt-2 overflow-x-auto">
                <table className="w-full text-sm text-gray-500 dark:text-gray-400">
                    <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr className="text-left">
                        <td
                            scope="col"
                            className="px-6 py-3 text-blue-600 font-bold"
                        ></td>
                        {headers.map((header) => (
                            <th
                                key={header}
                                scope="col"
                                className="px-6 py-3 text-blue-600"
                            >
                                {header}
                            </th>
                        ))}
                        <td scope="col" className="px-6 py-3 text-blue-600 font-bold">
                            Action
                        </td>
                    </tr>
                    </thead>
                    <tbody className="divide-y divide-gray-200">
                    {data.map((item, index) => (
                        <tr key={index} className="mt-3">
                            <td>
                                <div className="ml-5">
                                    <div
                                        className="bg-gray-200 rounded-sm w-5 h-5 flex flex-shrink-0 justify-center items-center relative">
                                        <input
                                            placeholder="checkbox"
                                            type="checkbox"
                                            className="focus:opacity-100 checkbox opacity-0 absolute cursor-pointer w-full h-full"
                                        />
                                        <div className="check-icon hidden bg-indigo-700 text-white rounded-sm">
                                            <svg
                                                className="icon icon-tabler icon-tabler-check"
                                                xmlns="http://www.w3.org/2000/svg"
                                                width="20"
                                                height="20"
                                                viewBox="0 0 24 24"
                                                strokeWidth="1.5"
                                                stroke="currentColor"
                                                fill="none"
                                                strokeLinecap="round"
                                                strokeLinejoin="round"
                                            >
                                                <path stroke="none" d="M0 0h24v24H0z"></path>
                                                <path d="M5 12l5 5l10 -10"></path>
                                            </svg>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            {headers.map((key) => (
                                <td key={key}>{String(item[key])}</td>
                            ))}
                            <td className="text-left">
                                {buttons.map((button, id) => {
                                    return (
                                        <button key={id}
                                                className="mr-3"
                                                onClick={() => button.action(index)}
                                        >
                                            {button.actionName}
                                        </button>
                                    );
                                })}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </section>
    );
}
