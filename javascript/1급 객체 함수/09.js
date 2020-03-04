const luckySeven = function() {
  return 7;
};

const test1 = luckySeven;

const test2 = luckySeven();

console.log(test1); // (출력값) [Function: luckySeven]

console.log(test2); // (출력값) 7
