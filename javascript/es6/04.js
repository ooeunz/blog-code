var hello = function() {
  console.log('hello');
};

var mark = 'MARK';

var obj = {
  inside: function() {
    console.log('객체 안에 바로 함수를 선언');
  },
  hello: hello,
};

obj[mark + 1] = '아이언맨';

obj.inside(); // (출력값) 객체 안에 바로 함수를 선언
obj.hello(); // (출력값) hello
console.log(obj.MARK1); // (출력값) 아이언맨
