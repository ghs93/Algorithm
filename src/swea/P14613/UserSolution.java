package swea.P14613;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class UserSolution
{
    class Link {
        int idx;
        int log;
        int init;
        Link connect;

        Link(int idx, int log, int init, Link connect) {
            this.idx = idx;
            this.log = log;
            this.init = init;
            this.connect = connect;
        }

        @Override
        public String toString() {
            return "{idx:" + this.idx + ", log:" + this.log + ", conn:" + this.connect + "}";
        }
    }

    class Log {
        int time;
        int index;

        Log(int time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public String toString() {
            return "{time: " + this.time + ", index: " + this.index + "}";
        }
    }
    int[][] map;
    HashMap<String, Link> who;
    HashMap<Integer, Log>[] changeLog;
    int index, address, chLog;

    /**
     * 각 테스트 케이스의 처음에 호출된다.
     * 테스트 케이스의 시작 시 생성되어 있는 리스트는 없다.
     */
    public void init()
    {
        map = new int[10][200000];
        who = new HashMap<>();
        changeLog = new HashMap[5010];
        index = 0;
        address = 0;
        chLog = 0;

        for (int i = 0; i < 5010; i++) {
            changeLog[i] = new HashMap<>();
        }
    }

    private String getName(char[] mName) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; mName[i] != 0; i++) {
            sb.append(mName[i]);
        }

        return sb.toString();
    }

    /**
     * mName 리스트가 생성되어 있지 않음이 보장된다.
     * mName 리스트를 새로 생성한다.
     * mName 리스트의 원소 개수는 mLength개가 된다.
     * mName 리스트의 i번째 원소의 값은 mListValue[i]가 된다. ( 0 ≤ i ≤ mLength - 1 )
     * 수행해야할 작업을 본문의 예시와 같이 나타내면, 아래와 같다.
     * > mName = [mListValue[0], mListValue[1], …, mListValue[mLength - 1]]
     * @param mName 리스트의 이름 ( 1 ≤ 길이 ≤ 20 )
     * @param mLength 리스트의 길이 ( 1 ≤ mLength ≤ 200,000 )
     * @param mListValue 원소들의 값 ( 0 ≤ mListValue[i] ≤ 32,767 )
     */
    public void makeList(char mName[], int mLength, int mListValue[])
    {
        String name = getName(mName);
        System.arraycopy(mListValue, 0, map[index], 0, mLength);
        who.put(name, new Link(address++, chLog++, index++, null));
    }

    /**
     * mDest 리스트가 생성되어 있지 않음이 보장된다.
     * mSrc 리스트가 생성되어 있음이 보장된다.
     * mDest 리스트를 새로 생성한다.
     * mSrc 리스트를 mDest 리스트에 복사한다.
     *
     * mCopy가 true인 경우, 값을 모두 복사하는 방식을 사용한다.
     * 이때 수행해야할 작업을 본문의 예시와 같이 나타내면, 아래와 같다.
     * > mDest = mSrc.copy()
     *
     * mCopy가 false인 경우, 주소만 복사하는 방식을 사용한다.
     * 이때 수행해야할 작업을 본문의 예시와 같이 나타내면, 아래와 같다.
     * > mDest = mSrc
     * @param mDest 리스트의 이름 ( 1 ≤ 길이 ≤ 20 )
     * @param mSrc 리스트의 이름 ( 1 ≤ 길이 ≤ 20 )
     * @param mCopy 복사 방식 ( mCopy = true or false )
     */
    public void copyList(char mDest[], char mSrc[], boolean mCopy)
    {
        String srcName = getName(mSrc);
        String destName = getName(mDest);

        if (mCopy) {
            who.put(destName, new Link(address++, chLog++, index, who.get(srcName)));

        } else {
            who.put(destName, who.get(srcName));
        }
//        System.out.println("==========copy==========");
//        System.out.println("dest: " + destName + ", who: " + who);
    }

    /**
     * mName 리스트의 mIndex번째 원소의 값을 mValue로 변경한다.
     * 수행해야할 작업을 본문의 예시와 같이 나타내면, 아래와 같다.
     * > mName[mIndex] = mValue
     * mName 리스트가 생성되어 있음이 보장된다.
     * @param mName 리스트의 이름 ( 1 ≤ 길이 ≤ 20 )
     * @param mIndex 원소의 인덱스 ( 0 ≤ mIndex ≤ mName 리스트의 길이 - 1 )
     * @param mValue 원소의 수정 후의 값 ( 0 ≤ mValue ≤ 32,767 )
     */
    public void updateElement(char mName[], int mIndex, int mValue)
    {
        String name = getName(mName);

        changeLog[who.get(name).idx].put(mIndex, new Log(chLog++, mValue));
//        System.out.println("==========update==========");
//        System.out.println("name: " + name + ", ch: " + changeLog[who.get(name).idx]);
    }

    /**
     * mName 리스트의 mIndex번째 원소를 반환한다.
     * mName 리스트가 생성되어 있음이 보장된다.
     * @param mName 리스트의 이름 ( 1 ≤ 길이 ≤ 20 )
     * @param mIndex 원소의 인덱스 ( 0 ≤ mIndex ≤ mName 리스트의 길이 - 1 )
     * @return mIndex번째 원소
     */
    public int element(char mName[], int mIndex)
    {
        String name = getName(mName);
//        System.out.println("==========element==========");
//        System.out.println("name: " + name + ", index: " + mIndex + ", ele: " + changeLog[who.get(name).idx].get(mIndex));
        if (changeLog[who.get(name).idx].get(mIndex) == null) {
            Link con = who.get(name).connect;
//            if (name.equals("c")) {
//                System.out.println("c is " + con);
//            }
            if (con == null) {
                return map[who.get(name).init][mIndex];
            }

            Link last = null;
            while (con != null) {
                if (changeLog[con.idx].get(mIndex) != null && changeLog[con.idx].get(mIndex).time < who.get(name).log) {
                    return changeLog[con.idx].get(mIndex).index;
                }

                last = con;
                con = con.connect;
            }

            return map[last.init][mIndex];

        } else {
//            System.out.println("==================================================");
//            System.out.println("name: " + name);
//            System.out.println("index: " + mIndex);
//            System.out.println("who: " + who.get(name).init);
//            System.out.println("change: " + changeLog[who.get(name).init].get(mIndex));
//            System.out.println();
            return changeLog[who.get(name).idx].get(mIndex).index;
        }
    }
}
