var quizJSONData = new Object();

$(document).ready(function () {
	
	  $('#Agri').click(function () {	  
		  course_type='Agri';
		  
		 $.get("./"+course_type, function(data) {
			 location.href='./'+course_type;
			
			});
		
	  });
	  $('#Maths').click(function () {
		  course_type='Maths';	  
		  $.get( "./"+course_type, function(data) {
			  location.href='./'+course_type;
			    
			});
		  
	  });
	  var course_type= $('#instr').children('#quizID').text();
	  $('#start_quiz').click(function () {
		  
		  $('#instr,#startq').remove();
		  $('#questionId').removeClass('questionId');
		  $('#questionId').addClass('questionIdShow');
		  $('#buttonId').removeClass('buttonId');
		  $('#buttonId').addClass('buttonIdShow');
		  /*$('#prev').removeClass('prev');
		  $('#prev').addClass('prevShow');
		  $('#next').removeClass('next');
		  $('#next').addClass('nextShow');*/
		  $('#uploadfile').removeClass('uploadfileShow');
		  $('#uploadfile').addClass('uploadfile');
		  $('#executeQuery').removeClass('executeQueryShow');
		  $('#executeQuery').addClass('executeQuery');
		  $('#timer').removeClass('timer');
		  $('#timer').addClass('timerShow'); 	  		 
		 
	});
	  
  //function loadQuiz(course_type){   
	  $.getJSON("./startQuizAdmin/"+course_type, function(data) {
	    	console.log(data);
	    	
	    	quizJSONData=data;  	
            var count=quizJSONData.length;
	    	var nextIndex=0;
	    	var prevIndex=0;
	    	var currentIndex=0;
	    	var checkListSize=0;
	    	var resultCount=0;
	    	var result=0;
	    	//var selected_value=null;
	    	//$.each(quizJSONData, function (i, item) {    		
	    	if(quizJSONData[0].question_type == 'Radio'){
	    	$('#questionId').html('<p>' +quizJSONData[0].questionID+'.&nbsp;&nbsp;'+quizJSONData[0].question+ '</p>');
	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"' + 'value="'+quizJSONData[0].option_1+'">'+quizJSONData[0].option_1+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_2+'">'+quizJSONData[0].option_2+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_3+'">'+quizJSONData[0].option_3+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_4+'">'+quizJSONData[0].option_4+ '</input></p>');	
	    	}else if(quizJSONData[0].question_type == 'CheckBox'){
	    		$('#questionId').html('<p>' +quizJSONData[0].questionID+'.&nbsp;&nbsp;'+quizJSONData[0].question+ '</p>');
		    	$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[0].questionID+'"' + 'value="'+quizJSONData[0].option_1+'">'+quizJSONData[0].option_1+ '</input></p>');
	   		    $('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_2+'">'+quizJSONData[0].option_2+ '</input></p>');
	   		    $('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_3+'">'+quizJSONData[0].option_3+ '</input></p>');
	   		    $('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_4+'">'+quizJSONData[0].option_4+ '</input></p>');	
	    	}else if(quizJSONData[0].question_type == 'Bool'){
      			$('#questionId').html('<p>' +quizJSONData[0].questionID+'.&nbsp;&nbsp;'+quizJSONData[0].question+ '</p>');
      	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"' + 'value="'+quizJSONData[0].option_1+'">'+quizJSONData[0].option_1+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_2+'">'+quizJSONData[0].option_2+ '</input></p>');
      		}  
	    	//}); 		     
   		
	    	$('#next').click(function () {
           	 if(nextIndex<=count){      			  
           		nextIndex++; 	    		
           		$('#prev').removeClass('prev');
    		    $('#prev').addClass('prevShow');
    		    $('#next').removeClass('next1');
      		    $('#next').addClass('next');
      		  if(quizJSONData[nextIndex].question_type == 'Radio'){
      			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
      	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
      		}else if(quizJSONData[nextIndex].question_type == 'CheckBox'){
      			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
      	    	$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
      			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
      			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
      			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
      		}else if(quizJSONData[nextIndex].question_type == 'Bool'){
      			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
      	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
      		}  
      		}
               	
      		if(nextIndex==count-1){
      			confirm('You Reached the Last Question, Do You want to Submit the Quiz !!!');
      			$('#next').removeClass('next');
      		    $('#next').addClass('nextShow');
      		    $('#submit').removeClass('submitbtn');
    		    $('#submit').addClass('submitbtnShow');
               	}
           	});
	    	
	    	$('#prev').click(function () {     		
	    		
	    		
	    		if(prevIndex<=nextIndex){      			  
	    			nextIndex--;
	    		
	    		$('#next').removeClass('nextShow');
	    		//alert($('input:radio[name=Option_'+quizJSONData[nextIndex].questionID+']').checked);
	      		$('#next').addClass('next');
	      		
	      		 if(quizJSONData[nextIndex].question_type == 'Radio'){
	       			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
	       	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
	       			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
	       			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
	       			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
	       		}else if(quizJSONData[nextIndex].question_type == 'CheckBox'){
	       			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
	       	    	$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
	       			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
	       			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
	       			$('#questionId').append('<p><input type="checkbox" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
	       		}else if(quizJSONData[nextIndex].question_type == 'Bool'){
	      			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
	      	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
	      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
	      		}   
	    		}
	    		
	    		//alert('resultCount after prev'+resultCount);
	    		//selected_value1 = $('input:radio[name=Option_'+quizJSONData[nextIndex].questionID+']:checked').val();		   
	   		 });
	    	
	//Test Code Starts Here
	    	$('#questionId').change(function(){    	
	    		//$('input').click(function(){
	    		$.each(quizJSONData, function (i, item) {		    			
	    			//$('input').click(function(){
	    			//alert('Answer here is '+quizJSONData[i].answer_value);
	    			//var selected_value = $("input:checked").val();
	    			var selected_value = $('input:radio[name=Option_'+quizJSONData[i].questionID+']:checked').val();
	    			var selected_value_Ch_answers = new Array();
	    			$('input:checkbox[name=Option_'+quizJSONData[i].questionID+']:checked').each(function () {	
	    				selected_value_Ch_answers.push($(this).val());
	    			if(selected_value_Ch_answers==quizJSONData[i].answer_value){
	    	    				resultCount++;
	    	    	} 
	    			//alert('selected_value_Ch_answers'+ selected_value_Ch_answers);
	    			});//alert(selected_value);
	    			//alert('selected_value_Ch_answers'+ selected_value_Ch_answers);
	    			if(selected_value==quizJSONData[i].answer_value){
	    				resultCount++;
	    			}    			
	    		
	    			 });		
	    		});
	    			
	 //Test Code Ends Here		
	
	    	$('#submit').click(function () {    	
	    	 //alert('resultCount after submit'+resultCount);
	    	alert('Are You Sure you want to Submit the Quiz');
	    	  $('#result').removeClass('result');
	  		  $('#result').addClass('resultShow');
	    	  $('#questionId').removeClass('questionIdShow');
	  		  $('#questionId').addClass('questionId');
	  		  $('#buttonId').removeClass('buttonIdShow');
	  		  $('#buttonId').addClass('buttonId');
	  		  $('#timer').removeClass('timerShow');
			  $('#timer').addClass('timer');
			  
	    		result=(resultCount*100)/count;
	    		resultTotal=result.toFixed(2);
	    		
	    	  $('#result').html('<h4> Your Total Score is ::</h4>');
	    	  $('#result').append('<h1>'+resultTotal+'%</h1>');
	    	  $('#showans').removeClass('showansbtn');
		  	  $('#showans').addClass('showansbtnShow');
		  	  $('#showAnswer').removeClass('showAnswer');
		  	  $('#showAnswer').addClass('showAnswerShow');
	    	});
	  
	    	$('#showans').click(function () {
	    		$('#result').removeClass('resultShow');
		  		$('#result').addClass('result');
		  		$('#showans').removeClass('showansbtnShow');
			  	$('#showans').addClass('showansbtn');
	    		$.each(quizJSONData, function (i, item) {
	    			$('#showAnswer').append('<p>'+quizJSONData[i].questionID+'.&nbsp;&nbsp;'+quizJSONData[i].question+'&nbsp;&nbsp;<strong>'+quizJSONData[i].answer_value+ '</strong></p>');    			
	    		});
	    		$('#retakeQuiz').removeClass('retakeQuiz');
			  	$('#retakeQuiz').addClass('retakeQuizShow');
	    	});
	    });
	  //}
  
});

	
