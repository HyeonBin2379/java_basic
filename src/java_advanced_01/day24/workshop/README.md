# WorkShop - 자바소켓프로그래밍 구현사항 정리

## 1. 구현한 기능 목록 정리
### 1) 서버 시작/종료
- 지정 포트로 listen (기본 5000)
- Ctrl+C, 예외 발생 시 소켓·스레드 정리 후 종료

### 2) 멀티 클라이언트 처리
- 각 클라이언트를 스레드(또는 스레드풀)로 처리
- 브로드캐스트: 한 사용자의 메시지를 모든 사용자에게 전달

### 3) 닉네임 등록
- 접속 후 첫 메시지 입력 형식: `NICK <이름>`

### 4) 입장/퇴장 알림
- 예: `Yumi joined` /  `SinSaegae left`

### 5) 기본/추가 명령
- `/quit` : 클라이언트 종료
- `/who` : 현재 접속자 목록 출력
- `/w <nick> <text>` : 특정 클라이언트에게 귓속말 보내기

### 6) 문자 인코딩 UTF-8
- 한글 입출력 정상 동작(구현)


## 2. 실행 결과

### ChatServer

- 인텔리제이의 실행 중지 버튼을 눌러서 강제종료
- 학생 A, B, C가 채팅방에 차례대로 입장하여 동시에 채팅 메시지를 송수신

<img width="400" height="700" alt="ChatServer" src="https://github.com/user-attachments/assets/1c9cfd0f-2620-48c8-b972-fff3420d026c" />

---

### ChatClient

* 서버는 채팅방에 새로운 학생들이 입장할 때마다 모든 학생들에게 안내메시지를 전송
* 학생 A는 채팅방 접속자들의 닉네임을 확인
* 학생 B는 A에게 귓속말(/w) 전송 -> 특정 클라이언트만 채팅 메시지 확인 가능
* 학생 C는 채팅방에서 퇴장 -> 퇴장 시 채팅방에 남아 있는 모든 학생들에게 퇴장 안내 메시지 출력
* 모든 채팅 내역은 서버에서 확인 가능
(특정 기능을 수행하는 명령어를 채팅창에 입력했을 경우, 명령어 대신 그 처리 결과를 채팅창에 출력)

<img width="488" height="739" alt="ChatClientA" src="https://github.com/user-attachments/assets/51069a90-6fea-42b3-9da3-5ab544b01c40" />

<img width="493" height="623" alt="ChatClientB" src="https://github.com/user-attachments/assets/5e576a6a-4259-4381-9655-c88ba490f701" />

<img width="494" height="615" alt="ChatClientC" src="https://github.com/user-attachments/assets/ca285924-429e-4d2a-9904-f2fdfe66e9b8" />




