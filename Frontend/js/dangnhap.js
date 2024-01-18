document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("btn-signin").addEventListener("click", async function (event) {
        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const resultMessage = document.getElementById("result");

        if (!username || !password) {
            resultMessage.innerText = "Điền thiếu thông tin";
            return;
        }

        // Create a FormData object and append the username and password
        const formData = new FormData();
        formData.append("username", username);
        formData.append("password", password);

        try {
            const response = await axios.post("http://localhost:8080/api/auth/signin", formData, {
                headers: {
                    "Content-Type": "text/form-data",
                },
            });

            const data = response.data;

            if (data) {
                resultMessage.innerText = "Đăng nhập thành công";
                // You can redirect to another page or perform other actions upon successful login
            } else {
                resultMessage.innerText = `Đăng nhập thất bại: ${data.message}`;
            }
        } catch (error) {
            console.error("Error:", error);
            resultMessage.innerText = "Đã xảy ra lỗi khi kết nối đến máy chủ";
        }
    });
});