INSERT INTO QUESTION_TABLE (QUESTION_ID, QUESTION, OPTION_1, OPTION_2,
  OPTION_3, OPTION_4)
  VALUES (1, 'What is the Capital of India', 'New Delhi', 'Hyderabad',
    'Mumbai', 'Chennai');

INSERT INTO USER_REG (USER_ID, PASSWORD, USER_TYPE)
  VALUES ('admin', 'admin', 'admin');

DELETE FROM QUESTION_TABLE
 WHERE QUESTION_ID in (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

DELETE FROM USER_REG
 WHERE USER_ID = 'user';

ALTER TABLE QUESTION_TABLE
ADD QUESTION_TYPE VARCHAR(225);

ALTER TABLE QUESTION_TABLE
ADD ANSWER_VALUE VARCHAR(225);

ALTER TABLE USER_REG
ADD USER_TYPE VARCHAR(225);

ALTER TABLE QUESTION_TABLE
ADD COURSE_TYPE VARCHAR(225);

SELECT ANSWER_VALUE
  FROM QUESTION_TABLE
  
Select * from QUESTION_TABLE where COURSE_TYPE='Agri';  