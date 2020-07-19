class Member {
    private memberId: string;

    constructor(memberId: string) {
        this.memberId = memberId;
    }

    getMemberId() {
        return this.memberId;
    }
}

const member: Member = new Member('윤자이');
console.log(member.getMemberId());
