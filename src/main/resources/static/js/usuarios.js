// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarUsuarios();
    $('#usuarios').DataTable();
    actualizarEmailDelUsuario();
});
function actualizarEmailDelUsuario(){
    document.getElementById('txt-email-usuario').outerHTML=localStorage.email;
}
async function cargarUsuarios() {

    const request = await fetch('api/listUsuario', {
        method: 'GET',
        headers: getHeaders()
    });
    const usuarios = await request.json();


    let listadoHTML = '';
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick="deleteUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></iclassName </a>';

        let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;

        usuarioHTL = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre
            + " " + '' + usuario.apellido + '</td><td>'
            + usuario.email + '</td><td>' + telefonoTexto + '</td><td>' + botonEliminar + '</td></tr>';

        listadoHTML += usuarioHTL;
    }
    document.querySelector('#usuarios tbody').outerHTML = listadoHTML
}
function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization':localStorage.token
    };

}
async function deleteUsuario(id) {
    const request = await fetch('api/deleteUsuario/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
}
