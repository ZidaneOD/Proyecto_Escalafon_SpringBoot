$(document).ready(function () {
    //on ready
});

async function registrarCargo() {
    let datos = {};
    datos.tipoCargo = document.getElementById('txtTipoCargo').value;
    datos.estado=1;

    const request = await fetch('api/postCargo', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("El cargo fue creado con exito")
    window.location.href = 'usuarios.html'
}