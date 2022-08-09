db.users.find({"email" : {$regex : "@hotmail.com"}}).first();
db.users.find({"age" : {$gte : 25}}).sort({ name: 1 });