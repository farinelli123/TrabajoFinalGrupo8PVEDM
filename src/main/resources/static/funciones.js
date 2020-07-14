function eliminart(id) {
	console.log(id);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/deleteTripulante/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal(" Registro eliminado!", {
		      icon: "error",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listarTripulante";
		    	}
		    });
		  } 
		});
}
function eliminarv(id) {
	console.log(id);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/deleteVehiculo/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal(" Registro eliminado!", {
		      icon: "error",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listarVehiculo";
		    	}
		    });
		  } 
		});
}
function eliminarl(id) {
	console.log(id);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/deleteLocalidad/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal(" Registro eliminado!", {
		      icon: "error",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listarLocalidad";
		    	}
		    });
		  } 
		});
}
function eliminaru(id) {
	console.log(id);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/deleteUsuario/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal(" Registro eliminado!", {
		      icon: "error",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listarUsuario";
		    	}
		    });
		  } 
		});
}




