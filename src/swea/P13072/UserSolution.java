package swea.P13072;

/**
 * SWEA 13072. 병사관리
 * @author hoseong
 * @category
 */
class UserSolution
{
    class Soldier {
        int id;
        int version;
        Soldier next;

        Soldier() {}

        Soldier(int id, int version) {
            this.id = id;
            this.version = version;
            this.next = null;
        }

        Soldier(int id, int version, Soldier soldier) {
            this.id = id;
            this.version = version;
            this.next = soldier;
        }

        @Override
        public String toString() {
            return "id: " + id + ", version: " + version;
        }
    }

    class Team {
        Soldier[] head = new Soldier[6];
        Soldier[] tail = new Soldier[6];
    }

    Team[] teams = new Team[6];
    int[] teamOfSoldier;
    int[] version;
    boolean[] isFire;

    public void init()
    {
        for (int i = 0; i < 6; i++) {
            teams[i] = new Team();

            for (int j = 0; j < 6; j++) {
                teams[i].head[j] = teams[i].tail[j] = new Soldier();
            }
        }

        teamOfSoldier = new int[100001];
        version = new int[100001];
        isFire = new boolean[100001];
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        Soldier soldier = new Soldier(mID, ++version[mID]);
        teams[mTeam].tail[mScore].next = soldier;
        teams[mTeam].tail[mScore] = soldier;

        teamOfSoldier[mID] = mTeam;
    }

    public void fire(int mID)
    {
        isFire[mID] = true;
    }

    public void updateSoldier(int mID, int mScore)
    {
        int mTeam = teamOfSoldier[mID];

        Soldier soldier = new Soldier(mID, ++version[mID]);
        teams[mTeam].tail[mScore].next = soldier;
        teams[mTeam].tail[mScore] = soldier;
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        if (mChangeScore < 0) {
            for (int j = 1; j <= 5; j++) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (Math.min(k, 5));
                if (j == k) continue;

                if (teams[mTeam].head[j].next == null) continue;
                teams[mTeam].tail[k].next = teams[mTeam].head[j].next;
                teams[mTeam].tail[k] = teams[mTeam].tail[j];
                teams[mTeam].head[j].next = null;
                teams[mTeam].tail[j] = teams[mTeam].head[j];
            }
        }
        if (mChangeScore > 0) {
            for (int j = 5; j >= 1; j--) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (Math.min(k, 5));
                if (j == k) continue;

                if (teams[mTeam].head[j].next == null) continue;
                teams[mTeam].tail[k].next = teams[mTeam].head[j].next;
                teams[mTeam].tail[k] = teams[mTeam].tail[j];
                teams[mTeam].head[j].next = null;
                teams[mTeam].tail[j] = teams[mTeam].head[j];
            }
        }
    }

    public int bestSoldier(int mTeam)
    {
        int mId = 0;
        for (int i = 5; i > 0; i--) {
            Soldier soldier = teams[mTeam].head[i].next;

            if (soldier == null) continue;

            while (soldier != null) {
                if (soldier.version == version[soldier.id] && !isFire[soldier.id]) {
                    mId = Math.max(mId, soldier.id);
                }

                soldier = soldier.next;
            }

            if (mId != 0) break;
        }

        return mId;
    }
}
