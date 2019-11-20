const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');
const quizwidgetModel=require('../models/quiz-widget.model.server');
//create
createStudent = student =>studentModel.create(student);
createQuestion = question => questionModel.create(question);
answerQuestion = (studentId, questionId, answer) => {
    answer.student = studentId;
    answer.question = questionId;
    answerModel.create(answer);
}
//delete
deleteStudent = studentId => studentModel.remove({_id: studentId});
deleteQuestion = questionId => questionModel.remove({_id: questionId});
deleteAnswer = (id) => answerModel.remove({_id: id});
deleteAnswerByStudentIdAndQuestionId = (studentId, questionId) => answerModel.remove({student: studentId, question: questionId});
//find
findAllStudents = () => studentModel.find();
findAllQuestions = () => questionModel.find();
findAllAnswers = () => answerModel.find();
findStudentById = studentId => studentModel.findById(studentId);
findQuestionById = questionId => questionModel.findById(questionId);
findAnswerById = answerId => answerModel.findById(answerId);
findAnswerByStudent = studentId => answerModel.find({student: studentId});
findAnswerByQuestion = questionId => answerModel.find({question: questionId});

//other

function truncateDatabase() {
    const allPromises = [answerModel.deleteMany({}),questionModel.deleteMany({}),studentModel.deleteMany({})];
    return Promise.all(allPromises);
}
function populateDatabase() {

    return Promise.all([
        createStudent({
            _id: 123,
            username: 'alice',
            password: 'alice',
            firstName: 'Alice',
            lastName: 'Wonderland',
            gradYear: 2020,
            scholarship: 15000
        }),
        createStudent({
            _id: 234,
            username: 'bob',
            password: 'bob',
            firstName: 'Bob',
            lastName: 'Hope',
            gradYear: 2021,
            scholarship: 12000
        }),
        createQuestion({
            _id: 321,
            question: 'Is the following schema valid?',
            points: 10,
            questionType: 'TRUE_FALSE',
            isTrue: false
        }),
        createQuestion({
            _id: 432,
            question: 'DAO stands for Dynamic Access Object.',
            points: 10,
            questionType: 'TRUE_FALSE',
            isTrue: false
        }),
        createQuestion({
            _id: 543,
            question: 'What does JPA stand for?',
            points: 10,
            questionType: 'MULTIPLE_CHOICE',
            choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
            correct: 1

        }),
        createQuestion({
            _id: 654,
            question: 'What does ORM stand for?',
            points: 10,
            questionType: 'MULTIPLE_CHOICE',
            choices: '"Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
            correct: 4
        }),
        answerQuestion(
            123,
            321,
            {
                _id: 123,
                trueFalseAnswer: true
            }),
        answerQuestion(
            123,
            432,
            {
                _id: 234,
                trueFalseAnswer: false
            }),
        answerQuestion(
            123,
            543,
            {
                _id: 345,
                multipleChoiceAnswer: 1
            }),
        answerQuestion(
            123,
            654,
            {
                _id: 456,
                multipleChoiceAnswer: 2
            }),
        answerQuestion(
            234,
            321,
            {
                _id: 567,
                trueFalseAnswer: false
            }),
        answerQuestion(
            234,
            432,
            {
                _id: 678,
                trueFalseAnswer: true
            }),
        answerQuestion(
            234,
            543,
            {
                _id: 789,
                multipleChoiceAnswer: 3
            }),
        answerQuestion(
            234,
            654,
            {
                _id: 890,
                multipleChoiceAnswer: 4
            })]);
}

module.exports = {createStudent,createQuestion,answerQuestion,deleteStudent,deleteQuestion,deleteAnswer,
    findAllStudents,findAllQuestions,findAllAnswers,findStudentById,findQuestionById,
    findAnswerByStudent,findAnswerByQuestion,truncateDatabase,populateDatabase,deleteAnswerByStudentIdAndQuestionId
}
