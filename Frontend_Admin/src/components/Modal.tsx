import React, { useState } from "react";

function Modal({
  buttonText,
  content,
}: {
  buttonText: string;
  content: React.ReactNode;
}) {
  const [open, setOpen] = useState<boolean>(false);

  return (
    <div>
      <button id="myBtn" onClick={() => setOpen(true)} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        {buttonText}
      </button>

      <div id="modal" style={{ display: open ? "block" : "none" }}>
        <div className="modal-content">
          <span className="close" onClick={() => setOpen(false)}>&times;</span>
          {content}
        </div>
      </div>
    </div>
  );
}

export default Modal;
