package swea.P14613;

import java.util.HashMap;

/**
 * SWEA 14613. 리스트 복사
 * @author hoseong
 * @category 구현, LinkedList
 */
class UserSolution
{
    class Node {
        int[] value;
        Log log;

        Node(int[] mListValue, int length) {
            this.value = new int[length];
            System.arraycopy(mListValue, 0, this.value, 0, length);
            this.log = null;
        }

        Node(Node node) {
            this.value = node.value;
            this.log = node.log;
        }
    }

    class Log {
        int index;
        int value;
        Log next;

        Log(int index, int value) {
            this.index = index;
            this.value = value;
            this.next = null;
        }
    }

    HashMap<String, Node> map;

    /**
     * 각 테스트 케이스의 처음에 호출된다.
     * 테스트 케이스의 시작 시 생성되어 있는 리스트는 없다.
     */
    public void init()
    {
        map = new HashMap<>();
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
        map.put(name, new Node(mListValue, mLength));
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
            map.put(destName, new Node(map.get(srcName)));

        } else {
            map.put(destName, map.get(srcName));
        }
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

        Node node = map.get(name);
        Log tmp = node.log;
        node.log = new Log(mIndex, mValue);
        node.log.next = tmp;
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

        Node node = new Node(map.get(name));

        while (node.log != null) {
            if (node.log.index == mIndex) {
                return node.log.value;
            }

            node.log = node.log.next;
        }

        return node.value[mIndex];
    }
}
