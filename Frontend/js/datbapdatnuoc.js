// Gửi yêu cầu GET đến API
var xhr = new XMLHttpRequest();
xhr.open("GET", "http://localhost:8080/api/ticket_types", true);
xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        // Xử lý dữ liệu nhận được
        var ticketTypes = JSON.parse(xhr.responseText);

        // Tìm giá vé và nước dựa trên name
        var priceBap = 0;
        var priceNuoc = 0;

        for (var i = 0; i < ticketTypes.length; i++) {
            if (ticketTypes[i].name === "bap") {
                priceBap = ticketTypes[i].price;
            } else if (ticketTypes[i].name === "nuoc") {
                priceNuoc = ticketTypes[i].price;
            }
        }

        // Lấy giá trị số lượng từ input fields
        var quantityBap = parseInt(document.getElementById("quantityBap").value) || 0;
        var quantityNuoc = parseInt(document.getElementById("quantityNuoc").value) || 0;

        // Tính tổng giá tiền
        var total = priceBap * quantityBap + priceNuoc * quantityNuoc;

        // Hiển thị kết quả
        document.getElementById("totalPrice").value = total;
    }
};

// Gửi yêu cầu
xhr.send();
