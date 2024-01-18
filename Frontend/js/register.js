// register.js

document.addEventListener("DOMContentLoaded", function () {
   
    // Function to handle form submission
    function submitForm(event) {
        event.preventDefault(); // Prevent the default form submission

        // Get form values
        var username = document.getElementById("username").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var cpassword = document.getElementById("cpassword").value;
        var role = 1

        // Validate form fields (you can implement your validation logic here)

        if (!username || !email || !password || !cpassword) {
            document.getElementById("result").innerText = "Điền thiếu thông tin";
            return;
        }

        // Example: Check if passwords match
        if (password !== cpassword) {
            document.getElementById("result").innerText = "Mật khẩu không khớp";
            return;
        }
       

        // Prepare data for API request
        var userData = {
            username: username,
            password: password,
            role: role

        };

        // Make API request (replace YOUR_API_ENDPOINT with your actual API endpoint)
        fetch("http://localhost:8080/api/auth/signup", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
            .then(response => response.json())
            .then(data => {
                // Handle API response
                if (data) {
                    document.getElementById("result").innerText = "Đăng ký thành công";
                    // You can redirect to another page or perform other actions upon successful registration
                } else {
                    document.getElementById("result").innerText = "Đăng ký thất bại: " + data.message;
                }
            })
            .catch(error => {
                console.error("Error:", error);
                document.getElementById("result").innerText = "Đã xảy ra lỗi khi kết nối đến máy chủ";
            });
    }

    // Attach the submitForm function to the click event of the registration button
    document.getElementById("btn-signup").addEventListener("click", submitForm);
});
