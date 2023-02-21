$(document).ready(function () {
    //on ready
});

async function registrarCargo() {
    let datos = {};
    datos.tipoCargo = document.getElementById('txtTipoCargo').value;

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

async function updateCargo(){
    let datos={};
    datos.idCargo=document.getElementById("txtidCargo").value;
    datos.tipoCargo=document.getElementById("txtTipoCargo").value;

    const request = await fetch('api/updateCargo/'+ datos.idCargo, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("El cargo fue modificado con exito")
    window.location.href = 'usuarios.html'
}