function ConstructorSample() {
  this.count = 1;
  this.increase = () => this.count++;
}

// case 1
const obj = new ConstructorSample();
obj.increase();
console.log(obj.count); // 2

// case 2
const increase = obj.increase;
increase();
console.log(obj.count); // 3
