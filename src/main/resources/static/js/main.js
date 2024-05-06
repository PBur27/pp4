getProducts = () => {
    return fetch("/api/products")
    .then(response => response.json());
}

const createProductHtml = (productData) => {
    const template = `
        <div>
            <h4>${productData.name}</h4>
            <span>${productData.price}</span>
            <button data-id="${productData.id}">Add to Cart</button>
        </div>
    `;
    const productEl = document.createElement('li');
    productEl.innerHTML = template.trim();

    return productEl;
}

document.addEventListener("DOMContentLoaded", () => {
    const productsListEl = document.querySelector("#productsList");
    getProducts()
        .then(productsAsJsonObj => productsAsJsonObj.map(createProductHtml))
        .then(productsAsHtmlEl => {
            productsAsHtmlEl.forEach(productEl => productsListEl.appendChild(productEl));
        })
});