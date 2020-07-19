const obj = {
  count: 1,
  increase: () => {
    this.count++;
  },
};

obj.increase();
console.log(obj.count); // 1

const assignNewObject = obj.increase;
assignNewObject();
console.log(obj.count); // 1