var a = 0;
var b = 0;

function registrar(){

	if(a == 1 && b == 1){
	    var json ={
	    		name: document.getElementById("nombre").value,
                username: document.getElementById("usuario").value,
	            email: document.getElementById("correo").value,
                password: document.getElementById("pwd").value,
                identification: document.getElementById("cedula").value,
                cellphone: document.getElementById("telefono").value,
	    }
	    
	    
	    
	    let configs = {
	            method: 'post',
	            body: JSON.stringify(json),
	            withCredentials: true,
	            credentials: 'include',
	            headers: {
	                'Content-type': 'text'
	            }
	    }
	    
	    console.log(configs.body);
	    fetch('./Register', configs)
	        .then(res => res.json())
	        .then(data => {console.log(data)
	        	let userData = data.userData;
	            if(data.status == 200){
	            	alert("Register successful");
	            }
	            	else{
	            		console.log("Register not successful");
	            	}
	            	
	    });
	}
}

function checkEmail() {
    var email = document.getElementById('correo');
    var mailFormat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!mailFormat.test(email.value)) {
        alert('Invalid email');
        email.focus;
        return false;
    }else{
    	a = 1;
    }
}

function checkPassword(){
    var password = document.getElementById('pwd');
    var passwordFormat= /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;

    if (!passwordFormat.test(password.value)) {
        alert('The password must have at least one number, one capital letter and above 6 small letters');
        password.focus;
        return false;
        console.log(a);
    }else{
    	b = 1;
    }
}

const check = () => {
	checkEmail();
	checkPassword();
	registrar();
	
}
