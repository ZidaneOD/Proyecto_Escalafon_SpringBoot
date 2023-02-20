// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarCargos();
    $('#cargos').DataTable();

});

async function cargarCargos() {

    const request = await fetch('api/listCargo', {
        method: 'GET',
        headers: getHeaders()
    });
    const cargos = await request.json();


    let listadoHTML = '';
    for (let cargo of cargos) {
        let botonEliminar = '<a href="#" onclick="deleteCargo(' + cargo.idCargo + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></iclassName </a>';

        CargoHTL = '<tr><td>' + cargo.idCargo + '</td><td>' +cargo.tipoCargo
            + '</td><td>' +cargo.estado + '</td><td>'+ botonEliminar + '</td></tr>';

        listadoHTML += CargoHTL;
    }
    document.querySelector('#cargos tbody').outerHTML = listadoHTML
}
function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization':localStorage.token
    };

}
async function deleteCargo(id) {
    const request = await fetch('api/deleteCargo/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
}
