const express = require("express")
const mongose = require("mongoose")
const bodyParser = require("body-parser")

const app = express()

mongose.connect("mongodb://localhost:27017/commentstore")

let count = 0

const commentSchema = new mongose.Schema({
    bookId: String,
    id: String,
    content: String
})

const Comment = mongose.model('Comment', commentSchema)

app.use(bodyParser.json())

app.get("/comments/:bookId",  async (req, res) => {
    const commentsDb = await Comment.find({bookId: req.params.bookId})
    const comments = []
    commentsDb.forEach(c => {
        comments.push({id: c.id, content:c.content, bookId: c.bookId})
    })
    res.status(200).json(comments)
})

app.post("/comments/:bookId",  async (req, res) => {
    const newComment = new Comment({
        bookId: req.params.bookId,
        content: req.body.content,
        id: ++count
    })
    const savedComment = await newComment.save()
    res.status(201).json(savedComment)

})

app.listen(3000,()=> {
    console.log("app started")
})