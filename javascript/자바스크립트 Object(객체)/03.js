let str = '자바스크립트 문자열은 index로 접근할 수 있습니다!';
str[0] = '윤';

console.log(`str: ${str}`); // str[0]을 '윤'으로 바꿨지만 수정되지 않습니다.

str = '윤자이 멋쟁이';
console.log(`str: ${str}`); // 새로운 문자열이 덧씌워지는 것을 알 수 있습니다.
