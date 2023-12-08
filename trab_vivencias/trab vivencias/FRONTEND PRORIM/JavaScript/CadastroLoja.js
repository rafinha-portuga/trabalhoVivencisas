//Pagina de cadastro de cupom
document.addEventListener('DOMContentLoaded', function () {
    const nomeLoja = document.getElementById('nomeLoja');
    const descricaoLoja = document.getElementById('descricaoLoja');

    lojaForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const url = "http://localhost:8080/lojas";
        const data = { 
            usuario: {
                idUsuario: 1
            },
            nomeLoja:  nomeLoja.value,
            descricaoLoja: descricaoLoja.value
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
          
        nomeLoja.value = '';
        descricaoLoja.value = '';
    })
});
