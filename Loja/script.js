
const CART_KEY = 'shopping_cart';


function getCart() {
    const cart = localStorage.getItem(CART_KEY);
    return cart ? JSON.parse(cart) : [];
}


function saveCart(cart) {
    localStorage.setItem(CART_KEY, JSON.stringify(cart));
}


function addToCart(product) {
    const cart = getCart();
    
    
    const existingProduct = cart.find(item => item.id === product.id);

    if (existingProduct) {
        
        existingProduct.quantity += 1;
    } else {
       
        product.quantity = 1;
        cart.push(product);
    }
    
    saveCart(cart);
    renderCart(); 
}


function clearCart() {
    localStorage.removeItem(CART_KEY);
    renderCart();
}


function renderCart() {
    const cart = getCart();
    const cartList = document.getElementById('cart-list');
    const cartTotalElement = document.getElementById('cart-total');
    let total = 0;

    
    cartList.innerHTML = '';

    if (cart.length === 0) {
        cartList.innerHTML = '<li>O carrinho está vazio.</li>';
        cartTotalElement.textContent = 'R$ 0,00';
        return;
    }

    cart.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.name} - ${item.quantity}x - R$ ${item.price.toFixed(2)}`;
        cartList.appendChild(li);
        total += item.price * item.quantity;
    });

    cartTotalElement.textContent = `R$ ${total.toFixed(2)}`;
}


document.addEventListener('DOMContentLoaded', renderCart);