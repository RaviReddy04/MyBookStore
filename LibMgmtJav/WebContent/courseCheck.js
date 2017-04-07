/**
 * 
 */



$("input:checkbox").click(function(){
    if ($("input:checkbox:checked").length > 3){
    	alert("Cant select");
      return false;
   }
});

