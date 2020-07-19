const obj = {
  count: 1,
  increase: function () {
    this.count++;
  },
};

obj.increase();
console.log(obj.count); // 2

const assignNewObject = obj.increase;
assignNewObject();
console.log(obj.count); // 2