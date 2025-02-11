const express = require('express');


const cors = require('cors');
const docs = []



const app = express();
app.use(cors());
app.use(express.json());

app.get('/orders',(req,res)=>{
    res.status(200).send(docs);
})
app.get('/orders/:id',(req,res)=>{
    let order = docs.filter((doc)=>doc.id===req.params.id);
    if(order){
        res.status(200).send(order);
    }
    else{
        res.status(404).send();
    }
})
app.post('/orders',(req,res)=>{
    docs.push(req.body);
    res.status(201).send(docs);
})
app.put('/orders/:id',(req,res)=>{
    if(req.body){
        docs.push(req.body);
        res.status(200).send(docs);
    }
    else{
        res.status(404).send()
    }
})
app.delete('/order/:id',(req,res)=>{
    docs = docs.filter((doc)=>doc.id!==req.params.id);
    res.status(200).send();
})




app.listen(5000,()=>console.log("working"));