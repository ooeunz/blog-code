const hello = function() {
  console.log('hello');
};

const mark = 'MARK';

const obj = {
  inside() {
    console.log('객체 안에 바로 함수를 선언');
  },
  hello,
  [mark + 1]: '아이언맨',
};

obj.inside(); // (출력값) 객체 안에 바로 함수를 선언
obj.hello(); // (출력값) hello
console.log(obj.MARK1); // (출력값) 아이언맨
