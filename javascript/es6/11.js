let obj = {
  name: '윤자이',
  age: 26,
  bag: {
    item_1: '지갑',
    item_2: '전공서적',
  },
};

const test = ({ name, age, bag }) => {
  console.log(`name: ${name}, age: ${age}, bag: ${bag}`);
};

test(obj);
