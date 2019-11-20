const mongoose = require('mongoose')
const questionSchema = require('./question.schema.server');
module.exports = mongoose.Schema({
    _id:Number,
    questions: [{
        ref: 'QuestionModel',
        type: mongoose.Schema.Types.ObjectId
    }]
}, {collection: 'question-widgets'});