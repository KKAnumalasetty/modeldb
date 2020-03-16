// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.versioning.*;
import ai.verta.modeldb.versioning.blob.visitors.Visitor;

public class NotebookCodeBlob {
    public PathDatasetBlob Path;
    public GitCodeBlob GitRepo;

    public NotebookCodeBlob() {
        this.Path = null;
        this.GitRepo = null;
    }

    public NotebookCodeBlob setPath(PathDatasetBlob value) {
        this.Path = value;
        return this;
    }
    public NotebookCodeBlob setGitRepo(GitCodeBlob value) {
        this.GitRepo = value;
        return this;
    }

    static public NotebookCodeBlob fromProto(ai.verta.modeldb.versioning.NotebookCodeBlob blob) {
        if (blob == null) {
            return null;
        }

        NotebookCodeBlob obj = new NotebookCodeBlob();
        {
            Function<ai.verta.modeldb.versioning.NotebookCodeBlob,PathDatasetBlob> f = x -> PathDatasetBlob.fromProto(blob.getPath());
            obj.Path = f.apply(blob);
        }
        {
            Function<ai.verta.modeldb.versioning.NotebookCodeBlob,GitCodeBlob> f = x -> GitCodeBlob.fromProto(blob.getGitRepo());
            obj.GitRepo = f.apply(blob);
        }
        return obj;
    }

    public ai.verta.modeldb.versioning.NotebookCodeBlob.Builder toProto() {
        ai.verta.modeldb.versioning.NotebookCodeBlob.Builder builder = ai.verta.modeldb.versioning.NotebookCodeBlob.newBuilder();
        {
            if (this.Path != null) {
                Function<ai.verta.modeldb.versioning.NotebookCodeBlob.Builder,Void> f = x -> { builder.setPath(this.Path.toProto()); return null; };
                f.apply(builder);
            }
        }
        {
            if (this.GitRepo != null) {
                Function<ai.verta.modeldb.versioning.NotebookCodeBlob.Builder,Void> f = x -> { builder.setGitRepo(this.GitRepo.toProto()); return null; };
                f.apply(builder);
            }
        }
        return builder;
    }

    public void preVisitShallow(Visitor visitor) throws ModelDBException {
        visitor.preVisitNotebookCodeBlob(this);
    }

    public void preVisitDeep(Visitor visitor) throws ModelDBException {
        this.preVisitShallow(visitor);
        visitor.preVisitDeepPathDatasetBlob(this.Path);
        visitor.preVisitDeepGitCodeBlob(this.GitRepo);
    }

    public NotebookCodeBlob postVisitShallow(Visitor visitor) throws ModelDBException {
        return visitor.postVisitNotebookCodeBlob(this);
    }

    public NotebookCodeBlob postVisitDeep(Visitor visitor) throws ModelDBException {
        this.Path = visitor.postVisitDeepPathDatasetBlob(this.Path);
        this.GitRepo = visitor.postVisitDeepGitCodeBlob(this.GitRepo);
        return this.postVisitShallow(visitor);
    }
}