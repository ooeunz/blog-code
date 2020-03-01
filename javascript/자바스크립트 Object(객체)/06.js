const obj = {
  name: '윤자이',
  age: 26,
  bag: {
    item_1: '지갑',
    item_2: '전공서적',
  },
};

// 프로퍼티 접근
console.log(obj.name);

console.log(obj.bag.item_1);

console.log(obj['bag']['item_1']);

// 새로운 프로퍼티 생성
obj.wallet = 20000;

obj['student'] = true;

// 프로퍼티 삭제
delete obj.age;

console.log(obj);
