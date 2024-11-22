import React from "react";

function Modal({
  open,
  setOpen,
  content,
}: {
  open: boolean;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
  buttonText: string;
  content: React.ReactNode;
}) {
  return (
    <div id="modal" style={{ display: open ? "block" : "none" }}>
      <div className="modal-content">
        <span className="close" onClick={() => setOpen(false)}>
          &times;
        </span>
        {content}
      </div>
    </div>
  );
}

export default Modal;
