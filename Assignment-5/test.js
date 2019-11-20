require('./data/db')();
const dao = require('./data/daos/university.dao.server');
const assert = require('assert');

function testInitialCount() {
    return Promise.all([
        testStudentsInitialCount(),
        testQuestionsInitialCount(),
        testAnswersInitialCount()
    ]);
    // testStudentsInitialCount();
    // testQuestionsInitialCount();
    // testAnswersInitialCount();
}
function testDeleteMethod() {
    return Promise.all([
        testDeleteAnswer(),
        testDeleteQuestion(),
        testDeleteStudent()
    ])
    // testDeleteAnswer();
    // testDeleteQuestion();
    // testDeleteStudent();
}

function testStudentsInitialCount() {
    dao.findAllStudents().then(
        users => assert(users.length == 2, "fail to validate student number, student number is:" + users.length));
}

function testQuestionsInitialCount() {
    dao.findAllQuestions().then(
        qs => assert(qs.length == 4, "fail to validate question number, question number is:" + qs.length));
}

function testAnswersInitialCount() {
    dao.findAllAnswers().then(
        ans => assert(ans.length == 8, "fail to validate answer number, answer number is:" + ans.length));
}

function testDeleteAnswer() {
    dao.deleteAnswerByStudentIdAndQuestionId(234, 654).then(
        () => {dao.findAllAnswers().then(ans => assert(ans.length == 7))}
    ).then(
        () => {dao.findAnswerByStudent(234).then(ans => assert(ans.length == 3))}
    );
}

function testDeleteQuestion() {
    dao.deleteQuestion(321).then(
        () => {dao.findAllQuestions().then(qs => assert(qs.length == 3))}
    );
}
function testDeleteStudent() {
    dao.deleteStudent(234).then(
        () => {dao.findAllStudents().then(students => assert(students.length == 1))}
    );
}
 dao.truncateDatabase().then(function(data){return dao.populateDatabase();}).then(function(data){return testInitialCount();}).then(function(data){return testDeleteMethod();}).then(console.log("test complete"));
    // .then(function(data){return testQuestionsInitialCount();}).then(function(data){return testAnswersInitialCount();})
   //  .then(function(data){return testDeleteAnswer();}).then(function(data){return testDeleteQuestion();}).then(function(data){return testDeleteStudent();})
