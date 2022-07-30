
document.addEventListener("DOMContentLoaded", ()=>{
    let arrInputsEstado = document.querySelectorAll("estadoPrestamo");
    for(let i = 0; i < arrInputsEstado.length; i++){
        let inputEstado = arrInputsEstado[i];
        let btnCerrarPrestamo = inputEstado.nextSibling.firstChild;
        if(inputEstado.value.toLowerCase() != "en biblioteca")
            btnCerrarPrestamo.disabled = true;
    }
})