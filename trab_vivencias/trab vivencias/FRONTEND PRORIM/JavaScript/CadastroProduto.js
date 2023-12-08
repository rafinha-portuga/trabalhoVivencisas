//Pagina de cadastro de cupom
document.addEventListener('DOMContentLoaded', function () {
    const nomeProduto = document.getElementById('nomeProduto');
    const descricaoProduto = document.getElementById('descricaoProduto');
    const precoProduto = document.getElementById('precoProduto');
    const idLoja = document.getElementById('idLoja');

    produtoForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const url = "http://localhost:8080/produtos";
        const data = {
            descricaoProduto: descricaoProduto.value,
            nomeProduto: nomeProduto.value,
            preco: parseFloat(precoProduto.value),
            loja: {
              idLoja: idLoja.value
            }
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
          
        nomeProduto.value = '';
        descricaoProduto.value = '';
        precoProduto.value = '';
        idLoja.value = '';
    })
});
