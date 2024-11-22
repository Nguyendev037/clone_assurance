import React, { useEffect } from "react";

function Snackbar({
  open,
  setOpen,
  text,
}: {
  open: boolean;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
  text: string;
}) {
  useEffect(() => {
    setTimeout(() => {
      setOpen(false);
    }, 3000);
  }, [open, setOpen]);

  return (
    <div id="snackbar" className={open ? "show" : ""}>
      {text}
    </div>
  );
}

export default Snackbar;
