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
	  $.getJSON("./startQuiz/"+course_type, function(data) {
	    	console.log(data);
	    	
	    	quizJSONData=data;
	    	var count=quizJSONData.length;
	    	var nextIndex=0;
	    	var prevIndex=0;
	    	var currentIndex=0;
	    	var checkListSize=0;
	    	var resultCount=0;
	    	var result=0;
	    	//var selected_value;
	    	//$.each(quizJSONData, function (i, item) {    		
	    	$('#questionId').html('<p>' +quizJSONData[0].questionID+'.&nbsp;&nbsp;'+quizJSONData[0].question+ '</p>');
	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"' + 'value="'+quizJSONData[0].option_1+'">'+quizJSONData[0].option_1+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_2+'">'+quizJSONData[0].option_2+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_3+'">'+quizJSONData[0].option_3+ '</input></p>');
   		    $('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[0].questionID+'"'+'value="'+quizJSONData[0].option_4+'">'+quizJSONData[0].option_4+ '</input></p>');
	    	//}); 		  
   		    
   		// alert(selected_value);
	    	$('#next').click(function () {
           	 if(nextIndex<=count){      			  
           		nextIndex++; 	    		
           		$('#prev').removeClass('prev');
    		    $('#prev').addClass('prevShow');
    		    $('#next').removeClass('next1');
      		    $('#next').addClass('next');
           		//currentIndex=nextIndex
      			//alert('clickIndex:: NEXT::'+firstIndex);
      			$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
      	    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
      			$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
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
	    		//alert('currentIndex:: currentIndex::'+currentIndex);
	    		if(prevIndex<=nextIndex){      			  
	    			nextIndex--;
	    			$('#next').removeClass('nextShow');
	      		    $('#next').addClass('next');
				$('#questionId').html('<p>' +quizJSONData[nextIndex].questionID+'.&nbsp;&nbsp;'+quizJSONData[nextIndex].question+ '</p>');
		    	$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"' + 'value="'+quizJSONData[nextIndex].option_1+'">'+quizJSONData[nextIndex].option_1+ '</input></p>');
				$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_2+'">'+quizJSONData[nextIndex].option_2+ '</input></p>');
				$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_3+'">'+quizJSONData[nextIndex].option_3+ '</input></p>');
				$('#questionId').append('<p><input type="radio" name="Option_'+quizJSONData[nextIndex].questionID+'"'+'value="'+quizJSONData[nextIndex].option_4+'">'+quizJSONData[nextIndex].option_4+ '</input></p>');
	   		 }
	    		//selected_value1 = $('input:radio[name=Option_'+quizJSONData[nextIndex].questionID+']:checked').val();		   
	   		 });
	    	
	    	$('#questionId').change(function(){
	    		$.each(quizJSONData, function (i, item) {
	    			
	    			var selected_value = $("input:checked").val();
	    			
	    			if(selected_value==quizJSONData[i].answer_value){
	    				resultCount++;
	    				//$('#resultDetail').append('<p>' +quizJSONData[i].questionID+'.&nbsp;&nbsp;'+quizJSONData[i].question+'</p>');
	    				//$('#resultDetail').append('<p style="color:green">Correct Answer :'+selected_value+'</p>');
	    			}/*else if(selected_value!=quizJSONData[i].answer_value){    				
	    				$('#resultDetail').append('<p>' +quizJSONData[i].questionID+'.&nbsp;&nbsp;'+quizJSONData[i].question+'</p>');
	    				$('#resultDetail').append('<p style="color:red">Wrong Answer</p>');
	    			}*/
	    				
	    		});
	    			
	    		
	   });
	    	$('#submit').click(function () {    	
	    	// alert(selected_value);
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


