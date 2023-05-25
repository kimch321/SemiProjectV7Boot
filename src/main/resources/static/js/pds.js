// 새글쓰기
const writebtn = document.querySelector("#writebtn");
writebtn?.addEventListener('click', () => {
    const pdsfrm = document.forms.pdsfrm;
    if (pdsfrm.title.value === '') alert('제목을 작성하세요!');
    else if (pdsfrm.content.value === '') alert('본문을 작성하세요!');
    else if (grecaptcha.getResponse() === '') alert('자동가입방지를 확인하세요!');
    else {
        pdsfrm.method = 'post';
        // 파일을 업로드하는 폼 데이터를 서버로 전송하기 위한 필수적인 설정
        pdsfrm.enctype = "multipart/form-data";
        pdsfrm.submit();
    }
});

// 목록보기
// 새글쓰기 버튼
const newbtn = document.querySelector("#newbtn");
newbtn?.addEventListener('click', () => {
    location.href = '/pds/write';
});