'use strict';
var Member = /** @class */ (function () {
    function Member(memberId) {
        this.memberId = memberId;
    }
    Member.prototype.getMemberId = function () {
        return this.memberId;
    };
    return Member;
})();
var member = new Member('윤자이');
console.log(member.getMemberId());
console.log(member.memberId);
