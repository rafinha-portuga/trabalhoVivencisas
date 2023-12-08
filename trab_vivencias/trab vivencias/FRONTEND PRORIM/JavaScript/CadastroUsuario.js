//Pagina de cadastro de cupom
document.addEventListener('DOMContentLoaded', function () {
    const nome = document.getElementById('nome');
    const email = document.getElementById('email');
    const senha = document.getElementById('senha');
    const tipoUsuario = document.getElementById('tipoUsuario');

    usuarioForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const url = "http://localhost:8080/usuarios";
        const data = 
        {
          email: email.value,
          nome: nome.value,
          senha: senha.value,
          tipoUsuario: tipoUsuario.value
        }
        
        fetch(url, {
            method: "POST",
            mode: "cors",
            cache: "no-cache",
            credentials: "same-origin",
            headers: {
              "Content-Type": "application/json",
            },
            redirect: "follow",
            referrerPolicy: "no-referrer",
            body: JSON.stringify(data),
          });
          
        nome.value = '';
        email.value = '';
        senha.value = '';
        tipoUsuario.value = '';
    })
});
